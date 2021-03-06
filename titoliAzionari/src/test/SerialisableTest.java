package test;
import java.io.Serializable;
import java.util.*;
import titoliAzionari.*;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sam on 22/05/17.
 */
public class SerialisableTest {

    @Test
    public void isSerializable(){
      isSerializable(ElencoTitoli.class);
      isSerializable(Portafoglio.class);
      isSerializable(Titolo.class);
      isSerializable(Lotto.class);
      isSerializable(Contenitore.class);
    }

    private void isSerializable(Class t){
        assertTrue( t.getCanonicalName() + " do not implements Serializable", Serializable.class.isAssignableFrom(t));

    }

}

