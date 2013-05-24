import static com.google.protobuf.Descriptor.*;
import static com.google.protobuf.Plugin.*;

import com.google.protobuf.Descriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
/**
 * @author Teaey
 * @email masfay@163.com
 * @since 2013-05-24
 */
public final class ProtocGenTeaey
{
    private static final Logger logger = LoggerFactory.getLogger(ProtocGenTeaey.class);
    public static void main(String[] args) throws IOException
    {
        //		ExtensionRegistry registry = ExtensionRegistry.newInstance();
        //		Options.registerAllExtensions(registry);
        //		PluginProtos.CodeGeneratorRequest request = PluginProtos.CodeGeneratorRequest.
        //				parseFrom(System.in, registry);
        CodeGeneratorResponse response;
        try
        {
            logger.info("Start Protoc Gen Teaey...");
            CodeGeneratorRequest request = CodeGeneratorRequest.
                    parseFrom(System.in);
            CodeGeneratorResponse.Builder responseBuilder = CodeGeneratorResponse.newBuilder();
            for (String each : request.getFileToGenerateList())
            {
                CodeGeneratorResponse.File.Builder fb = CodeGeneratorResponse.File.newBuilder();
                fb.setName(each);
                fb.setContent("test content");
                responseBuilder.addFile(fb.build());
                logger.info("file_to_generate:" + each);
            }
            for (FileDescriptorProto each : request.getProtoFileList())
            {
                logger.info("proto_file:" + each.toString());
            }
            response = responseBuilder.build();
        } catch (Exception e)
        {
            // 出错，报告给 protoc ，然后退出
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            CodeGeneratorResponse.newBuilder().setError(sw.toString()).
                    build().writeTo(System.out);
            System.out.flush();
            return;
        }
        response.writeTo(System.out);
        System.out.flush();
    }
}
