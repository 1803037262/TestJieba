import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import java.util.Map;  
import java.util.Map.Entry; 

public enum ExecPython  
{  
    INSTANCE;  
      
    public void execute(String scriptFile, Map<String,String> properties)  
    {  
        //��ȡpython������  
        final PythonInterpreter inter = JythonEnvironment.getInstance().getPythonInterpreter();  
        inter.exec("import sys");
        inter.exec("sys.path.append('D:/Python34/Lib/site-packages/jieba')");
        inter.exec("sys.path.append('D:/Python34/Lib/site-packages/jieba/analyse/__init__.py')");
        inter.exec("sys.path.append('D:/Python34/Lib/site-packages/jieba/analyse/analyzer.py')");
        inter.exec("sys.path.append('D:/Python34/Lib/site-packages/jieba/analyse/textrank.py')");
        inter.exec("sys.path.append('D:/Python34/Lib/site-packages/jieba/analyse/tfidf.py')");
        inter.exec("sys.path.append('D:/jython2.5.4rc1/Lib')");//jython�Լ���
        //����python����,python�ű��п���ʹ��  
        for (Entry<String,String> entry : properties.entrySet())  
        {  
            inter.set(entry.getKey(), entry.getValue());  
        }  
          
        try  
        {  
            //ͨ��python����������python�ű�  
            inter.execfile(scriptFile); 
            //第二种方式 调用python中的方法
            PyFunction func = (PyFunction) inter.get("getWbfx",
                    PyFunction.class);
            PyObject aaa = func.__call__(Py.newStringUTF8("根据重点。"));
            System.out.println(new String(aaa.toString().getBytes("iso8859-1"),"UTF8"));
        }  
        catch (Exception e)  
        {  
            System.out.println("ExecPython encounter exception:" + e);  
        }  
    }  
}  
