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
        //第一种方法
		/*py.argv.append (Py.newStringUTF8("根据重点车辆动态管控和分析研判系统自身的技术特点，系统功能主要包括功能多级应用、车辆信息专题库建设、全息车辆电子档案、重点车辆分析研判重点管控系统四大部分。一、建立省级建设、省市县和基层所队四级应用，对接各省级业务系统的建设、应用架构；二、建立丰富的机动车辆相关信息专题库。整合公安部门已有的机动车辆信息、驾驶员信息、车辆卡口轨迹信息、违章信息、高速公路收费站卡口信息以及部分社会资源（加油站、停车场等静态车轨信息），努力实现公安机关对机动车辆及相关信息的“零死角”全面掌控；三、建立重点车辆电子档案库。结合重点人积分管控和重大事件预警防范经验，将车辆与案事件、重点群体、重点人员等信息进行关联串并，搭建重点车辆积分预警分析模型，评估车辆危害程度，对犯罪嫌疑车辆进行分级管控，为公安机关研判分析、高效实战提供情报服务；四、建立重点车辆研判分析动态管控系统，一是实现全省重点车辆的轨迹布控、轨迹追踪查询；二是依托大数据处理技术，进行深度挖掘，针对我省情况特点，搭建重点车辆频繁出入、异地车辆出入、伴随车辆、套牌车辆统计分析模型，使得公安机关有效掌控重点车辆活动规律，为预防和打击涉恐、涉稳案件提供强力支撑；三是建立以“图像信息为切入口、多种公安信息为依托”的重点车辆动态管控实战应用新模式，实现人车、车案（事）、车车、车与群体的关联比对和联管联控，进一步提供情报研判工作的实效性。"));
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