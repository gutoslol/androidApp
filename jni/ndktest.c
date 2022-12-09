#include<jni.h>
#include<string.h>

jstring Java_com_example_androidapp_MainActivity_helloWorld(JNIEnv * env, jobject obj) {
    jstring strung = "CTF_ELF_J";
    return(*env) -> NewStringUTF(env, strung);
}

jstring Java_com_example_androidapp_MainActivity_sixtyFoar(JNIEnv * env, jobject obj) {
    jstring strung = "NYKRHAKRHCN_T]YHIRH";
    return(*env) -> NewStringUTF(env, strung);
}