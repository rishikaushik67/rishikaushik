package lesson8.labs.prob4;

@FunctionalInterface
public interface TriFunction<S, T, U, R> {
	R apply(S s, T t, U u);
}
