rem @echo off
set "EXEC=%CD%/bin/protoc"
set "PROTO_PATH=%CD%/proto/"
set "PLUGIN_PATH=%CD%/bin/"
%EXEC% --plugin=protoc-gen-teaey=%PLUGIN_PATH%protoc-gen-teaey.bat --teaey_out=./output --proto_path=%PROTO_PATH% %PROTO_PATH%test.proto
@pause