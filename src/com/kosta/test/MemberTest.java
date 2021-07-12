package com.kosta.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.kosta.dao.MemberDAO;
import com.kosta.dto.MemberDTO;

/*
 * 	1.db연결
 * 	2.preparedStatement 를 이용해서 dml   ->		executeUpdate
 * 								select->	executeQuery
 * 	3.executeUpdate -> row값받아서 확인!!
 * 	  executeQuery  -> resultSet을 이용하여 받아서 출력
 * 	4.close
 */
public class MemberTest {
	Scanner sc = new Scanner(System.in);
	MemberDAO dao = new MemberDAO();

	public void join() {

		System.out.println("아이디를 입력하세요");
		String id = sc.next();

		if (dao.checkid(id)) {
			System.out.println("중복된id입니다.");
		} else {
			System.out.println("패스워드를 입력하시오");
			String pwd = sc.next();
			System.out.println("이름을 입력하시오");
			String name = sc.next();
			System.out.println("이메일을 입력하시오");
			String email = sc.next();

			int result = dao.insert(id, pwd, name, email);

			if (result >= 1) {
				System.out.println(result + "개 row 추가완료");
			} else {
				System.out.println("추가 실패!!!!!!!!");
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
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		boolean status = dao.checkid(id);

		if (dao.checkid(id)) {
			System.out.println("패스워드를 입력하시오");
			String pwd = sc.next();
			System.out.println("이메일을 입력하시오");
			String email = sc.next();
			int result = dao.update(id, pwd, email);

			if (result >= 1) {
				System.out.println(id + "회원 수정완료");
			} else {
				System.out.println("수정 실패!!!!!!!!");
			}
		} else {
			System.out.println("없는id입니다.");
		}

	}

	public void del() {
		System.out.println("아이디를 입력하세요");
		String id = sc.next();

		boolean status = dao.checkid(id);

		if (dao.checkid(id)) {
			int result = dao.delete(id);

			if (result >= 1) {
				System.out.println(id + "번 회원 삭제완료");
			} else {
				System.out.println("삭제 실패!!!!!!!!");
			}
		} else {
			System.out.println("없는id입니다.");
		}

	}

	public void search() {
		System.out.println("아이디를 입력하세요");
		String id = sc.next();

		MemberDTO result = dao.getOne(id);
		if (result == null) {
			System.out.println("no search data");
		} else {
			System.out.println(result);
		}

	}

}
