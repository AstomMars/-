package hitc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.Action;
//import com.opensymphony.xwork2.ActionSupport;


import org.apache.struts2.ServletActionContext;

public class hitcAction {

		public String gotoPage1()
	    {
			
			String asd = "";
	        ServletActionContext.getRequest()  
	            .setAttribute("AccessBy1","<div>sjl</div>");
	        return Action.SUCCESS;  
	    }
	    
		
		private String userName ;//= request.getParameter("userName");//ҳ�������userName 
	    private String passWord ;//= request.getParameter("passWord");//ҳ�������passWord
	    private String qqId ;
	    
	    //private String title;
	    
		//private HttpServletRequest request;
	    //�����setter��getter���� 
	    
	    public String getUserName(){
			return userName;
	    }
	    public void setUserName(String userName){
	    	this.userName = userName;
	    }
	    
	    public String getPassWord(){
			return passWord;
	    }
	    public void setPassWord(String passWord){
	    	this.passWord = passWord;
	    }
	    /*
	    public String getTitle(){
	    	return qqId;
	    }
	    public void setTitle(String title){
	    	this.title = title;
	    }
	    */
	    public String getQqId(){
	    	return qqId;
	    }
	    public void setQqId(String qqId){
	    	this.qqId = qqId;
	    }
	    
	    
	    //ҵ���߼� 
	     
	    public String fillName(){
	    	ServletActionContext.getRequest()  
            	.setAttribute("Ccbt",userName);
	    	
	    	try {
		    	// 1���������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");// �������ݿ�����
				System.out.println("�������ݿ������ɹ�");
				String url = "jdbc:mysql://localhost:3306/hitc";// �������ݿ�hitc��url

				// ����hitcΪ������database�����ݿ⣩

				String user = "root";// ���ݿ���û���
				String password = "414732";// ���ݿ������
				// �������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ�");
				// 2������һ��sql���
				String selectsql = "select title from catalog";
				
				// 3��ִ��sql���
				Statement stmt = (Statement) conn.createStatement();// ����һ��Statement����
				ResultSet res = stmt.executeQuery(selectsql);
				int i = 1;
				while(res.next()){//set����
					String psd = res.getString("title");
					String title = "title" + i;
					ServletActionContext.getRequest()
		    			.setAttribute(title,"[topic]" + psd);
					i++;
				} 
				conn.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return Action.SUCCESS;
	    }
	    
	    public String zc()
	    {  
	    	
	    	try {

				// 1���������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");// �������ݿ�����
				System.out.println("�������ݿ������ɹ�");
				String url = "jdbc:mysql://localhost:3306/hitc";// �������ݿ�hitc��url

				// ����hitcΪ������database�����ݿ⣩

				String user = "root";// ���ݿ���û���
				String password = "414732";// ���ݿ������
				// �������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ�");

				String selectsql = "select hitc_id from users where hitc_name='"+ userName+"'";
				// 2������һ��sql���
				// ����һ��mysql���
				String sql;
				if(!qqId.equals("")){
					System.out.println(qqId);
					sql = "insert into users(hitc_name,password,qq) values('" +userName +"','"+passWord + "','"+qqId+"')";
				} else {
					sql = "insert into users(hitc_name,password) values('" +userName +"','"+passWord + "')";
				}
				
				// insert [into] ���� [(����1, ����2, ����3, ...)] values (ֵ1, ֵ2, ֵ3, ...);
				// select ������ from ������ [��ѯ����];����Ҫ��ѯ students ��������ѧ�������ֺ�����, �������
				// select name, age from students;
				// select ������ from ������ where ����;select * from students where
				// sex="male";
				// update ������ set ������=��ֵ where ��������;
				// delete from ������ where ɾ������;

				// http://www.cnblogs.com/mr-wid/archive/2013/05/09/3068229.html#d8

				// 3��ִ��sql���
				Statement stmt = (Statement) conn.createStatement();// ����һ��Statement����
				ResultSet res = stmt.executeQuery(selectsql);
				if(res.next()){//set���գ���hitc_name�Ѵ���
					
					conn.close();
					System.out.println("�û����Ѵ���");
					return Action.ERROR;
				} else {
					stmt.executeUpdate(sql);// ִ��sql���
					System.out.println("���뵽���ݿ�ɹ�");
					conn.close();
					System.out.println("�ر����ݿ�ɹ�");
					return Action.SUCCESS;
				}
				// 4���ر����ݿ�����
			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return Action.ERROR;
	    	
	    	
	    	/*
	    	System.out.println(userName);
	    	System.out.println(passWord);
	    	if(null != qqId){
	    		System.out.print(qqId);
	    	} else {
	    		System.out.print("nothing");
	    	}
	    	if (null!= userName && null != passWord  
		            && userName.equals("arne3166") && passWord.equals("111111")) {  
		            return Action.SUCCESS;
		        } else {  
		            return Action.ERROR;
		    } 
	    	
	    	/*
	        if (null!= userName && null != passWord  
	            && userName.equals("arne3166") && passWord.equals("111111")) {  
	            return Action.SUCCESS;
	        } else {  
	            return Action.ERROR;
	        }  
	        */
	    }
	    
	    public String login()
	    {
	    	//System.out.println(userName);
	    	//System.out.println(passWord);
	    	try {
	    	// 1���������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");// �������ݿ�����
			System.out.println("�������ݿ������ɹ�");
			String url = "jdbc:mysql://localhost:3306/hitc";// �������ݿ�hitc��url

			// ����hitcΪ������database�����ݿ⣩

			String user = "root";// ���ݿ���û���
			String password = "414732";// ���ݿ������
			// �������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("�������ݿ�ɹ�");
			// 2������һ��sql���
			String selectsql = "select password from users where hitc_name='"+ userName+"'";
			
			// 3��ִ��sql���
			Statement stmt = (Statement) conn.createStatement();// ����һ��Statement����
			ResultSet res = stmt.executeQuery(selectsql);
			if(res.next()){//set���գ���hitc_name�Ѵ���
				String psd = res.getString("password");
				if(psd.equals(passWord)){
					System.out.println(userName);
					System.out.println(psd);
					return Action.SUCCESS;
				}
				conn.close();
			} else {
				conn.close();
				System.out.println("�ر����ݿ�ɹ�");
				return Action.ERROR;
			}
			// 4���ر����ݿ�����
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return Action.ERROR;
	}  
	    
	    public String resultArtical(){
	    	//System.out.println("Title is "+title);
	    	
	    	String getName = ServletActionContext.getActionMapping().getName();
	    	getName = getName.substring(7);
	    	System.out.println("-----getName----->>"+getName);
	    	
	    	String[] tempList = getName.split("_");
	    	
	    	String hitcName = tempList[0];
	    	
	    	String classify = tempList[1].substring(0,7);
	    	System.out.println(classify);
	    	
	    	String tit = tempList[1].substring(7);
	    	System.out.println(tit);
	    	
	    	String cont = null;
	    	String hot = null;
	    	String branch = null;
	    	
	    	try {

				// 1���������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");// �������ݿ�����
				System.out.println("�������ݿ������ɹ�");
				String url = "jdbc:mysql://localhost:3306/hitc";// �������ݿ�hitc��url

				// ����hitcΪ������database�����ݿ⣩

				String user = "root";// ���ݿ���û���
				String password = "414732";// ���ݿ������
				// �������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ�");
				String selectsql;
				if(classify.equals("[topic]")){
		    		selectsql = "select * from catalog where title='"+ tit +"'";
		    	} else {
		    		selectsql = "select * from news where title='"+ tit +"'";
		    	}
		    	
				Statement stmt = (Statement) conn.createStatement();// ����һ��Statement����
				ResultSet res = stmt.executeQuery(selectsql);
		    	
				if(res.next()){//set����
					cont = res.getString("content");
					hot = res.getString("hot");
					branch = res.getString("xueyuan");
					System.out.println(branch);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	
	    	ServletActionContext.getRequest()  
        		.setAttribute("Ccbt",hitcName);
	    	ServletActionContext.getRequest()  
        		.setAttribute("title",classify + "[" + branch + "]" + tit);
	    	ServletActionContext.getRequest()  
    			.setAttribute("hot",hot);
	    	
	    	
	    	ServletActionContext.getRequest()
    			.setAttribute("content",cont);
    		
	    	return Action.SUCCESS;
	    }
	    
	    public String topicHot(){
	    	String getName = ServletActionContext.getActionMapping().getName();
	    	getName = getName.substring(10);
	    	System.out.println("-----getName----->>"+getName);
	    	
	    	try {
		    	// 1���������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");// �������ݿ�����
				System.out.println("�������ݿ������ɹ�");
				String url = "jdbc:mysql://localhost:3306/hitc";// �������ݿ�hitc��url

				// ����hitcΪ������database�����ݿ⣩

				String user = "root";// ���ݿ���û���
				String password = "414732";// ���ݿ������
				// �������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ�");
				// 2������һ��sql���
				String selectsql = "select * from catalog order by hot desc";
				
				// 3��ִ��sql���
				Statement stmt = (Statement) conn.createStatement();// ����һ��Statement����
				ResultSet res = stmt.executeQuery(selectsql);
				
				ServletActionContext.getRequest()  
            		.setAttribute("Ccbt",getName);
				
				System.out.println(userName);
				int i = 1;
				while(res.next()){//set����
					String psd = res.getString("title");
					String title = "title" + i;
					ServletActionContext.getRequest() 
		    			.setAttribute(title,"[topic]" + psd);
					i++;
				} 
				return Action.SUCCESS;
				
				// 4���ر����ݿ�����
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return Action.ERROR;
	    }
	    
	    public String topicBranch(){
	    	String getName = ServletActionContext.getActionMapping().getName();
	    	getName = getName.substring(13);
	    	System.out.println("-----getName----->>"+getName);
	    	
	    	try {
		    	// 1���������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");// �������ݿ�����
				System.out.println("�������ݿ������ɹ�");
				String url = "jdbc:mysql://localhost:3306/hitc";// �������ݿ�hitc��url

				// ����hitcΪ������database�����ݿ⣩

				String user = "root";// ���ݿ���û���
				String password = "414732";// ���ݿ������
				// �������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ�");
				// 2������һ��sql���
				String selectsql = "select * from catalog order by xueyuan asc";
				
				// 3��ִ��sql���
				Statement stmt = (Statement) conn.createStatement();// ����һ��Statement����
				ResultSet res = stmt.executeQuery(selectsql);
				
				ServletActionContext.getRequest()  
            		.setAttribute("Ccbt",getName);
				System.out.println(userName);
				int i = 1;
				while(res.next()){//set����
					String psd = res.getString("title");
					String title = "title" + i;
					ServletActionContext.getRequest() 
		    			.setAttribute(title,"[topic]" + psd);
					i++;
				} 
				return Action.SUCCESS;
				
				// 4���ر����ݿ�����
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return Action.ERROR;
	    }
	    
	    public String newsHot(){
	    	String getName = ServletActionContext.getActionMapping().getName();
	    	getName = getName.substring(9);
	    	System.out.println("-----getName----->>"+getName);
	    	
	    	try {
		    	// 1���������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");// �������ݿ�����
				System.out.println("�������ݿ������ɹ�");
				String url = "jdbc:mysql://localhost:3306/hitc";// �������ݿ�hitc��url

				// ����hitcΪ������database�����ݿ⣩

				String user = "root";// ���ݿ���û���
				String password = "414732";// ���ݿ������
				// �������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ�");
				// 2������һ��sql���
				String selectsql = "select * from news order by hot desc";
				
				// 3��ִ��sql���
				Statement stmt = (Statement) conn.createStatement();// ����һ��Statement����
				ResultSet res = stmt.executeQuery(selectsql);
				
				ServletActionContext.getRequest()  
        			.setAttribute("Ccbt",getName);
				System.out.println(userName);
				
				int i = 1;
				while(res.next()){//set����
					String psd = res.getString("title");
					String title = "title" + i;
					ServletActionContext.getRequest() 
		    			.setAttribute(title,"[news ]" + psd);
					i++;
				} 
				return Action.SUCCESS;
				
				// 4���ر����ݿ�����
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return Action.ERROR;
	    }
	    
	    public String newsBranch(){
	    	String getName = ServletActionContext.getActionMapping().getName();
	    	getName = getName.substring(12);
	    	System.out.println("-----getName----->>"+getName);
	    	
	    	try {
		    	// 1���������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");// �������ݿ�����
				System.out.println("�������ݿ������ɹ�");
				String url = "jdbc:mysql://localhost:3306/hitc";// �������ݿ�hitc��url

				// ����hitcΪ������database�����ݿ⣩

				String user = "root";// ���ݿ���û���
				String password = "414732";// ���ݿ������
				// �������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ�");
				// 2������һ��sql���
				String selectsql = "select * from news order by xueyuan asc";
				
				// 3��ִ��sql���
				Statement stmt = (Statement) conn.createStatement();// ����һ��Statement����
				ResultSet res = stmt.executeQuery(selectsql);
				
				ServletActionContext.getRequest()  
	        		.setAttribute("Ccbt",getName);
				System.out.println(userName);
				
				
				int i = 1;
				while(res.next()){//set����
					String psd = res.getString("title");
					String title = "title" + i;
					ServletActionContext.getRequest() 
		    			.setAttribute(title,"[news ]" + psd);
					i++;
				} 
				return Action.SUCCESS;
				
				// 4���ر����ݿ�����
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return Action.ERROR;
	    }
	    
}
