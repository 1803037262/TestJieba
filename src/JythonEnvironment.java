import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.python.core.Py;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

/** 
 * Jython环境,生存python解释器 
 * @author webim 
 * 
 */  
public final class JythonEnvironment  
{  
    private static JythonEnvironment INSTANCE = new JythonEnvironment();  
      
    /** 
     * 私有构造方法 
     */  
    private JythonEnvironment()  
    {  
    }  
      
    /** 
     * 获取单例 
     * @return JythonEnvironment 
     */  
    public static JythonEnvironment getInstance()  
    {  
        return INSTANCE;  
    }  
      
    /** 
     * 获取python系统状态,可根据需要指定classloader/sys.stdin/sys.stdout等 
     * @return PySystemState 
     */  
    private PySystemState getPySystemState()  
    {  
        PySystemState.initialize();  
        final PySystemState py = new PySystemState();
        //第一种方法 调用python中的__mian_方法 参与由sys.argv[1]接受
		/*py.argv.append (Py.newStringUTF8("根据重点车辆动。"));
        py.setClassLoader(getClass().getClassLoader());  */
        return py;  
    }  
    public static String stringToAscii(String value)  
    {  
        StringBuffer sbu = new StringBuffer();  
        char[] chars = value.toCharArray();   
        for (int i = 0; i < chars.length; i++) {  
            if(i != chars.length - 1)  
            {  
                sbu.append((int)chars[i]).append(",");  
            }  
            else {  
                sbu.append((int)chars[i]);  
            }  
        }  
        return sbu.toString();  
    }
    /** 
     * 获取python解释器 
     * @return PythonInterpreter 
     */  
    public PythonInterpreter getPythonInterpreter()  
    {  
        PythonInterpreter inter = new PythonInterpreter(null, getPySystemState());  
        return inter;  
    }  
} 