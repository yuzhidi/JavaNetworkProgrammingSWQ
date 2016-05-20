package hello;


/**
* hello/HelloServiceHelper.java .
* �� IDL-to-Java ������������ֲ�����汾 "3.2" ����
* ���� HelloService.idl
* 2006��12��18�� ����һ ����09ʱ14��13�� CST
*/

abstract public class HelloServiceHelper
{
  private static String  _id = "IDL:hello/HelloService:1.0";

  public static void insert (org.omg.CORBA.Any a, hello.HelloService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static hello.HelloService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (hello.HelloServiceHelper.id (), "HelloService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static hello.HelloService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HelloServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, hello.HelloService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static hello.HelloService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof hello.HelloService)
      return (hello.HelloService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      hello._HelloServiceStub stub = new hello._HelloServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static hello.HelloService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof hello.HelloService)
      return (hello.HelloService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      hello._HelloServiceStub stub = new hello._HelloServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}


/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Java�����̾���>>                       *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
