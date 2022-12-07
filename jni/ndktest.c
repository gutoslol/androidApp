#include<jni.h>
#include<string.h>

jstring Java_com_example_androidapp_MainActivity_helloWorld(JNIEnv * env, jobject obj) {
    return(*env) -> NewStringUTF(env,"I like turtles!");
}