package Chapter9.Test18;

/**
 * @author:YiMing
 * @create:2020/7/28,20:56
 * @version:1.0
 */
public class TricycleFactory implements CycleFactory{
    public Tricycle getCycle() { return new Tricycle(); }
}
