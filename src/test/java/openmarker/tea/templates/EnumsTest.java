package openmarker.tea.templates;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



public class EnumsTest extends AbstractTemplateTest {

    @Before
    public void setup() {
        addContext("EnumsApplication", new EnumsContext());
    }

    @Test
    public void testValues() throws Exception {
        assertEquals("0", executeSource(TEST_ENUM_SOURCE_1));
        assertEquals("INVALID", executeSource(TEST_ENUM_SOURCE_2));
        assertEquals("VALID", executeSource(TEST_ENUM_SOURCE_3));
        assertEquals("VALID", executeSource(TEST_ENUM_SOURCE_4));
        assertEquals("true", executeSource(TEST_ENUM_SOURCE_5));
        assertEquals("true", executeSource(TEST_ENUM_SOURCE_6));
        assertEquals("blah", executeSource(TEST_ENUM_SOURCE_7));
    }

    protected static final String TEST_ENUM_SOURCE_1 =
        "openmarker.tea.templates.EnumsTest$TestEnum.VALID.ordinal()";

    protected static final String TEST_ENUM_SOURCE_2 =
        "openmarker.tea.templates.EnumsTest$TestEnum.INVALID.name()";

    protected static final String TEST_ENUM_SOURCE_3 =
        "openmarker.tea.templates.EnumsTest$TestEnum.values()[0].name()";

    protected static final String TEST_ENUM_SOURCE_4 =
        "openmarker.tea.templates.EnumsTest$TestEnum.valueOf('VALID').name()";

    protected static final String TEST_ENUM_SOURCE_5 =
        "a = getTestEnum(0); if (a == openmarker.tea.templates.EnumsTest$TestEnum.VALID) { 'true' }";

    protected static final String TEST_ENUM_SOURCE_6 =
        "a = getTestEnum(1); if (a == openmarker.tea.templates.EnumsTest$TestEnum.INVALID) { 'true' }";

    protected static final String TEST_ENUM_SOURCE_7 =
        "openmarker.tea.templates.EnumsTest$TestEnum.VALID.test()";

    // TODO: if both left and right is enum, only do ==

    public static enum TestEnum {
        VALID,
        INVALID;

        public String test() { return "blah"; }
    }

    public static class EnumsContext {
       public TestEnum getTestEnum(int value) {
           return TestEnum.values()[value];
       }
    }
}
