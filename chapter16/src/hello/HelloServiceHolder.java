package hello;

/**
* hello/HelloServiceHolder.java .
* �� IDL-to-Java ������������ֲ�����汾 "3.2" ����
* ���� HelloService.idl
* 2006��12��18�� ����һ ����09ʱ14��13�� CST
*/

public final class HelloServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public hello.HelloService value = null;

  public HelloServiceHolder ()
  {
  }

  public HelloServiceHolder (hello.HelloService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = hello.HelloServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    hello.HelloServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return hello.HelloServiceHelper.type ();
  }

}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Java�����̾���>>                       *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
