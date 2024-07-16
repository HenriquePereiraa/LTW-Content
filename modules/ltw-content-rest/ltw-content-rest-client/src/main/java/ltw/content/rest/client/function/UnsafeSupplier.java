package ltw.content.rest.client.function;

import javax.annotation.Generated;

/**
 * @author Henrique Pereira
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}