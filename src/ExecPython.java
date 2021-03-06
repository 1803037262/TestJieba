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
        //引入python的第三方库 结巴分词
        inter.exec("sys.path.append('D:/Python34/Lib/site-packages/jieba')");
        inter.exec("sys.path.append('D:/jython2.5.4rc1/Lib')");//jython自己的库
        //����python����,python�ű��п���ʹ��  
        for (Entry<String,String> entry : properties.entrySet())  
        {  
            inter.set(entry.getKey(), entry.getValue());  
        }  
          
        try  
        {  
            //ͨ��python����������python�ű�  
            inter.execfile(scriptFile); 
            //第二种方式 调用python中的方法getWbfx(参数为中文)
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
