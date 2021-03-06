package openmarker.tea.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import openmarker.tea.compiler.Compiler;
import openmarker.tea.util.ResourceCompilationProvider;
import openmarker.trove.util.ClassInjector;

import org.junit.Before;
import org.junit.Test;

public class ResourceCompilerTest {

    private Compiler compiler;
    private ResourceCompilationProvider provider;

    @Before
    public void init() {
        provider = new ResourceCompilationProvider();
        compiler = new Compiler(ClassInjector.getInstance(this.getClass().getClassLoader()));
        compiler.addCompilationProvider(provider);
    }

    @Test
    public void testSourceExists() {
        assertTrue(compiler.sourceExists("test"));
        assertTrue(compiler.sourceExists("abc"));
        assertFalse(compiler.sourceExists("blah"));
    }

    @Test
    public void testGetAllTemplateNames() throws IOException {
        String[] names = compiler.getAllTemplateNames();
        assertEquals(0, names.length);
    }

    @Test
    public void testCompile() throws IOException {
        String[] results = compiler.compile(new String[] { "test", "abc" });
        assertEquals(2, results.length);
    }

}
