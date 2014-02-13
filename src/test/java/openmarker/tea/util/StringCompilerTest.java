package openmarker.tea.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import openmarker.tea.compiler.Compiler;
import openmarker.tea.util.StringCompilationProvider;
import openmarker.trove.util.ClassInjector;

import org.junit.Before;
import org.junit.Test;

public class StringCompilerTest {

    private Compiler compiler;
    private StringCompilationProvider provider;

    @Before
    public void init() {
        compiler = new Compiler(ClassInjector.getInstance(this.getClass().getClassLoader()));
        provider = new StringCompilationProvider();
        provider.setTemplateSource("test", "<% template test() 'test' %>");
        provider.setTemplateSource("abc", "<% template abc() 'abc' %>");
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
        assertEquals(2, names.length);
    }

    @Test
    public void testCompile() throws IOException {
        String[] results = compiler.compileAll();
        assertEquals(2, results.length);
    }

}
