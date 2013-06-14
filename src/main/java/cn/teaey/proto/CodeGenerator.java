package cn.teaey.proto;
import com.google.protobuf.Descriptor;
import com.google.protobuf.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * User: Teaey
 * Date: 13-6-14
 */
public interface CodeGenerator
{
    static final Logger log = LoggerFactory.getLogger(CodeGenerator.class);
    public static class DefaultCodeGenerator implements CodeGenerator
    {
        @Override
        public Plugin.CodeGeneratorResponse.Builder generate(Plugin.CodeGeneratorRequest request)
        {
            //here get all the proto files
            for (String each : request.getFileToGenerateList())
            {
                log.info("file_to_generate:" + each);
            }
            //here get all messages descriptior
            for (Descriptor.FileDescriptorProto each : request.getProtoFileList())
            {
                log.info("proto_file:" + each.toString());
            }
            return Plugin.CodeGeneratorResponse.newBuilder();
        }
    }
    Plugin.CodeGeneratorResponse.Builder generate(Plugin.CodeGeneratorRequest request);
}
