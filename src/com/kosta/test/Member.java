package com.kosta.test;

import java.util.Scanner;

public class Member {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberTest mt =new MemberTest();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원수정");
			System.out.println("3. 회원삭제");
			System.out.println("4. 회원조회");
			System.out.println("5. 전체보기");
			System.out.println("6. 종료");
			System.out.println("기능 선택?");
			String choice = sc.next();
			switch (choice) {
			case "1":
				mt.join();
				break;
			case "2":
				mt.modi();
				break;
			case "3":
				mt.del();
				break;
			case "4":
				mt.search();
				break;
			case "5":
				mt.searchall();
				break;
			case "6":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;

			default:
				System.out.println("코드를 잘못 입력하셨습니다.");
				break;
			}
	}

}
}