package com.kosta.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.kosta.dao.MemberDAO;
import com.kosta.dto.MemberDTO;

/*
 * 	1.db����
 * 	2.preparedStatement �� �̿��ؼ� dml   ->		executeUpdate
 * 								select->	executeQuery
 * 	3.executeUpdate -> row���޾Ƽ� Ȯ��!!
 * 	  executeQuery  -> resultSet�� �̿��Ͽ� �޾Ƽ� ���
 * 	4.close
 */
public class MemberTest {
	Scanner sc = new Scanner(System.in);
	MemberDAO dao = new MemberDAO();

	public void join() {

		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();

		if (dao.checkid(id)) {
			System.out.println("�ߺ���id�Դϴ�.");
		} else {
			System.out.println("�н����带 �Է��Ͻÿ�");
			String pwd = sc.next();
			System.out.println("�̸��� �Է��Ͻÿ�");
			String name = sc.next();
			System.out.println("�̸����� �Է��Ͻÿ�");
			String email = sc.next();

			int result = dao.insert(id, pwd, name, email);

			if (result >= 1) {
				System.out.println(result + "�� row �߰��Ϸ�");
			} else {
				System.out.println("�߰� ����!!!!!!!!");
			}
		}
	}

	public void searchall() {
		ArrayList<MemberDTO> list = dao.getAll();
		Iterator<MemberDTO> ita = list.iterator();

		while (ita.hasNext()) {
			MemberDTO dto = ita.next();
			System.out.println(dto);
		}
	}

	public void modi() {
		// TODO Auto-generated method stub
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();
		boolean status = dao.checkid(id);

		if (dao.checkid(id)) {
			System.out.println("�н����带 �Է��Ͻÿ�");
			String pwd = sc.next();
			System.out.println("�̸����� �Է��Ͻÿ�");
			String email = sc.next();
			int result = dao.update(id, pwd, email);

			if (result >= 1) {
				System.out.println(id + "ȸ�� �����Ϸ�");
			} else {
				System.out.println("���� ����!!!!!!!!");
			}
		} else {
			System.out.println("����id�Դϴ�.");
		}

	}

	public void del() {
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();

		boolean status = dao.checkid(id);

		if (dao.checkid(id)) {
			int result = dao.delete(id);

			if (result >= 1) {
				System.out.println(id + "�� ȸ�� �����Ϸ�");
			} else {
				System.out.println("���� ����!!!!!!!!");
			}
		} else {
			System.out.println("����id�Դϴ�.");
		}

	}

	public void search() {
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();

		MemberDTO result = dao.getOne(id);
		if (result == null) {
			System.out.println("no search data");
		} else {
			System.out.println(result);
		}

	}

}
