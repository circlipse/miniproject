package com.kosta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import com.kosta.dto.MemberDTO;

public class MemberDAO {
	
	
	private Connection getConnection() {
		String className="oracle.jdbc.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:XE";
		String user="hr";
		String pwd="hr";
		Connection conn =null;
		
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url,user,pwd);
			
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return conn;
	}
	//insert
	public int insert(String id,String pwd, String name,String email) {
		Connection conn = getConnection();
		PreparedStatement pstmt =null;
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into member(memberno,id,pwd,name,email) ");
		sql.append(" values (memberseq.nextval,?,?,?,?) ");
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(pstmt,conn);
		}
		return result;
	}
	//update
	public int update(String id, String pwd,String email) {
		Connection conn = getConnection();
		PreparedStatement pstmt =null;
		StringBuilder sql = new StringBuilder();
		sql.append(" update member set pwd = ? , email = ? where id = ? ");
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, pwd);
			pstmt.setString(2, email);
			pstmt.setString(3, id);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(pstmt,conn);
		}
		return result;
	}
	
	//delete
		public int delete(String id) {
			Connection conn = getConnection();
			PreparedStatement pstmt =null;
			StringBuilder sql = new StringBuilder();
			sql.append(" delete from member where id= ?	");
			int result = 0;
			try {
				pstmt=conn.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				System.out.println(e);
			}finally {
				close(pstmt,conn);
			}
			return result;
		}
	
	//select
	public List<MemberDTO> getAll() {
		List<MemberDTO> lists = new ArrayList<MemberDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		

		sql.append("	select 				");
		sql.append("			memberno	");
		sql.append("			,id			");
		sql.append("			,pwd		");
		sql.append("			,name		");
		sql.append("			,email		");
		sql.append("			,joindate	");
		sql.append("	from member			");
		sql.append("	order by memberno	");
		
		try {
			pstmt=conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();

			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setMemberno(rs.getInt("memberno"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setJoindate(rs.getString("joindate"));
				
				lists.add(dto);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}finally {
			close(pstmt,conn);
		}
		return lists;
	}
	private void close(PreparedStatement pstmt,Connection conn) {
		if(pstmt!=null) try {pstmt.close();}catch(SQLException e){}
		if(conn!=null) try {conn.close();}catch(SQLException e){}
	}
	
	public boolean checkid(String id) {
		boolean val =false;
		Connection conn = getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		sql.append("	select 				");
		sql.append("			id			");
		sql.append("	from member			");
		try {
			pstmt=conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("id").equals(id)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("checkID err: " +e);
		}finally {
			close(pstmt,conn);
		}
		return false;
	}
	
	public MemberDTO getOne(String id) {
		Connection conn = getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		MemberDTO dto = null;

		sql.append("select memberno, id, pwd, name, email, joindate from member where id=?	");
		
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				dto = new MemberDTO();
				
				dto.setMemberno(rs.getInt("memberno"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setJoindate(rs.getString("joindate"));

				return dto;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}finally {
			close(pstmt,conn);
		}
		return dto;
	}
	
}