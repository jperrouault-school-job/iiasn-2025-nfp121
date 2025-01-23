package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class PointV2 {
    private AtomicInteger x = new AtomicInteger();
    private AtomicInteger y = new AtomicInteger();

    public void translate(int xx, int yy) {
        this.x.addAndGet(xx);
        this.y.addAndGet(yy);
    }

    @Override
    public String toString() {
        return "[x = " + this.x.get() + ", y = " + this.y.get() + "]";
    }
}
