package com.example.androidapp

object XORCryptor {

    private fun generateMask(value: Int): Int {
        var mask = 0
        var prV = value
        while (prV != 0) {
            if (prV and 1 == 1) mask++
            prV = prV shr 1
        }
        mask = mask or ((8 - mask) shl 4)
        mask = mask xor ((mask shl 4) or (mask shr 4))
        return mask xor value
    }

    fun processBytes(srcBytes: ByteArray, keyBytes: ByteArray): ByteArray {
        var keyIdx = 0
        for (i in srcBytes.indices) {
            if (keyIdx == keyBytes.size) keyIdx = 0
            val b = srcBytes[i].toInt()
            val k = generateMask(keyBytes[keyIdx++].toInt())
            srcBytes[i] = b.xor(k).toByte()
        }
        return srcBytes
    }
}