package cbandi;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestByteBuffer {

    @Test
    public void test() {
        ByteBuffer byteBuffer = ByteBuffer.wrap("Hello! World".getBytes(StandardCharsets.UTF_8));

        System.out.println(byteBuffer);
        System.out.println(new String(byteBuffer.array(), StandardCharsets.UTF_8));
    }
}
