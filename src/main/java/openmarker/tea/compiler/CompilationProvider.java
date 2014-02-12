package openmarker.tea.compiler;

import java.io.IOException;

public interface CompilationProvider {

    public boolean sourceExists(String name);

    public String[] getKnownTemplateNames(boolean recurse)
        throws IOException;

    public CompilationSource createCompilationSource(String name);

}
