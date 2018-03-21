import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TestA {
public static void main(String[] args) {
	//这是通过wind中cmd命令指令python文件
	/* try {
          //String a=getPara("car").substring(1),b="D34567",c="LJeff34",d="iqngfao";
          //String[] args1=new String[]{ "python", "D:\\pyworkpeace\\9_30_1.py", a, b, c, d };
          //Process pr=Runtime.getRuntime().exec(args1);
          
          Process pr=Runtime.getRuntime().exec("cmd /c python D:/pythonwork/TestPython/TestJieba.py �����ص㳵����̬�ܿغͷ�������ϵͳ����ļ����ص㣬ϵͳ������Ҫ�������ܶ༶Ӧ�á�������Ϣר��⽨�衢ȫϢ�������ӵ������ص㳵�����������ص�ܿ�ϵͳ�Ĵ󲿷֡�һ������ʡ�����衢ʡ���غͻ��������ļ�Ӧ�ã��ԽӸ�ʡ��ҵ��ϵͳ�Ľ��衢Ӧ�üܹ������������ḻ�Ļ������������Ϣר��⡣���Ϲ����������еĻ���������Ϣ����ʻԱ��Ϣ���������ڹ켣��Ϣ��Υ����Ϣ�����ٹ�·�շ�վ������Ϣ�Լ����������Դ������վ��ͣ�����Ⱦ�̬������Ϣ����Ŭ��ʵ�ֹ������ضԻ��������������Ϣ�ġ������ǡ�ȫ���ƿأ����������ص㳵�����ӵ����⡣����ص��˻��ֹܿغ��ش��¼�Ԥ���������飬�������밸�¼����ص�Ⱥ�塢�ص���Ա����Ϣ���й�����������ص㳵������Ԥ������ģ�ͣ���������Σ���̶ȣ��Է������ɳ������зּ��ܿأ�Ϊ�����������з�������Чʵս�ṩ�鱨�����ġ������ص㳵�����з�����̬�ܿ�ϵͳ��һ��ʵ��ȫʡ�ص㳵���Ĺ켣���ء��켣׷�ٲ�ѯ���������д����ݴ���������������ھ������ʡ����ص㣬��ص㳵��Ƶ�����롢��س������롢���泵�������Ƴ���ͳ�Ʒ���ģ�ͣ�ʹ�ù���������Ч�ƿ��ص㳵������ɣ�ΪԤ���ʹ����֡����Ȱ����ṩǿ��֧�ţ����ǽ����ԡ�ͼ����ϢΪ����ڡ����ֹ�����ϢΪ���С����ص㳵����̬�ܿ�ʵսӦ����ģʽ��ʵ���˳����������£�������������Ⱥ��Ĺ����ȶԺ��������أ���һ���ṩ�鱨���й�����ʵЧ�ԡ�·������һ��С˵���");
          BufferedReader in = new BufferedReader(new InputStreamReader(
            pr.getInputStream()));
          String line;
          while ((line = in.readLine()) != null) {
           System.out.println(line);
          }
          in.close();
          pr.waitFor();
         } 
       catch (Exception e) {
          e.printStackTrace();
     }*/
    
	//python所在位置
    String scriptFile = "D:/pythonwork/TestPython/TestJieba.py"; 
    //实际上没有什么用
    Map<String,String> properties = new HashMap<String,String>();  
      
    ExecPython.INSTANCE.execute(scriptFile, properties);
	}
}
