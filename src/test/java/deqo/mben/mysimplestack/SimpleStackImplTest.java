package deqo.mben.mysimplestack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleStackImplTest {

    SimpleStack simpleStack;

    @Before
    public void setUp() throws Exception {
        simpleStack = new SimpleStackImpl();
        System.out.println("Je suis exécuté avant chaque test !");
    }

    @Test
    public void TestIsEmpty() {
        // dans le cas vide
        assertEquals(true, simpleStack.isEmpty());

        // ajout d'un élément
        String e1="toto";
        simpleStack.push(new Item(new String(e1)));

        // dans le cas non vide
        assertEquals(false, simpleStack.isEmpty());

    }

    @Test
    public void TestGetSize() {
        // dans le cas vide
        assertEquals(0,simpleStack.getSize());

        // ajout de deux éléments
        String e1="toto";
        String e2="titi";
        simpleStack.push(new Item(new String(e1)));
        simpleStack.push(new Item(new String(e2)));

        // dans le cas deux éléments
        assertEquals(2,simpleStack.getSize());
    }

    @Test
    public void testPush() {
        // création d'un élément
        Item ita = new Item(new Integer(5));
        assertEquals(0,simpleStack.getSize());
        simpleStack.push(ita);

        // la pile doit avoir un élément en plus
        assertEquals(1,simpleStack.getSize());

        // vérifier qu'on a bien ajouté un int
        Item res=simpleStack.peek();
        assertTrue(res.getValue() instanceof Integer);

        // vérifier qu'il vaut bien 5
        Integer intgr = (Integer)res.getValue();
        assertEquals(5,intgr.intValue());
        assertEquals(ita.getValue(),intgr);

    }

    @Test
    public void testPeek() {
        // création d'un élément
        Item ita = new Item(new Integer(5));
        assertEquals(0,simpleStack.getSize());
        simpleStack.push(ita);

        // la pile doit avoir un élément en plus
        assertEquals(1,simpleStack.getSize());

        // on recupere le peek
        Item res=simpleStack.peek();

        // on ne doit pas avoir un élement en moins avec peek
        assertEquals(1,simpleStack.getSize());

        assertTrue(res.getValue() instanceof Integer);

        // vérifier qu'il vaut bien 5
        Integer intgr = (Integer)res.getValue();
        assertEquals(5,intgr.intValue());
    }

    @Test
    public void testPop() {
        // création d'un élément
        Item ita = new Item(new Integer(5));
        assertEquals(0,simpleStack.getSize());
        simpleStack.push(ita);

        // la pile doit avoir un élément en plus
        assertEquals(1,simpleStack.getSize());

        // on enlève un element
        Item res=simpleStack.pop();

        // on oit avoir un élement en moins avec pop
        assertEquals(0,simpleStack.getSize());

        assertTrue(res.getValue() instanceof Integer);

        // vérifier qu'il vaut bien 5
        Integer intgr = (Integer)res.getValue();
        assertEquals(5,intgr.intValue());
    }
}