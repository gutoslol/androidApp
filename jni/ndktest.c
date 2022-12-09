#include<jni.h>
#include<string.h>
#include<stdlib.h>

jstring Java_com_example_androidapp_MainActivity_helloWorld(JNIEnv * env, jobject obj) {
    jstring strung = "CTF_ELF_J";
    return(*env) -> NewStringUTF(env, strung);
}

jstring Java_com_example_androidapp_MainActivity_sixtyFoar(JNIEnv * env, jobject obj, jstring in) {
    const char* input = (*env) -> GetStringUTFChars(env, in, (jboolean *)0);
    char* output = malloc(sizeof(char) * strlen(input));
    char key[3] = {'D', 'J', 'K'};

    for(jint i = 0; i < strlen(input); i++) {
        output += input [i] ^ key [i % sizeof(key)];
    }

    return(*env) -> NewStringUTF(env, output);
}