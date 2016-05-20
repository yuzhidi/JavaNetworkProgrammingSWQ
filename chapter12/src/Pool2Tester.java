import java.sql.*;
public class Pool2Tester implements Runnable{
  ConnectionPool pool=new ConnectionPoolImpl2();
  public static void main(String args[])throws Exception{
    Pool2Tester tester=new Pool2Tester();
    Thread[] threads=new Thread[30];
    for(int i=0;i<threads.length;i++){
      threads[i]=new Thread(tester);
      threads[i].start();
      Thread.sleep(300);
    }
    
    for(int i=0;i<threads.length;i++){
      threads[i].join();
    }
    tester.close(); //�ر����ӳ�
  }
  public void close(){
    pool.close();
  }
  public void run(){
    try{
      Connection con=pool.getConnection();
      System.out.println(Thread.currentThread().getName()+": �����ӳ�ȡ��һ������"+con);
      Statement stmt=con.createStatement();
      stmt.executeUpdate("insert into CUSTOMERS (NAME,AGE,ADDRESS) " 
        +"VALUES ('С��',20,'�Ϻ�')");
 
      //�ͷ������Դ
      stmt.close();
      con.close();
      System.out.println(Thread.currentThread().getName()+": �ͷ�����"+con);
    }catch(Exception e){e.printStackTrace();}
  }
}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Java�����̾���>>                       *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
