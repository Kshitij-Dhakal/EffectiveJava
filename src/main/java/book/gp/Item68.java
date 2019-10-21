package book.gp;

/**
 * <h1>Adhere to generally accepted naming conventions.</h1>
 * <p>Package components should consist of lowercase alphabetic characters and raraly digits. That name of any package that will be used outside your organization should begin with your organization's internet domain name with the components reversed. for example <em>com.google</em>. Users must not create packages or modules whose names begin with java or javax. Meaningful abbreviations are encouraged. For example, <em>util</em> rather than <em>utilities</em>.</p>
 * <p>Class and interfacee names should consist of one or more words with first letter of each word capitalized. For example <em>List</em> or <em>FutureTask</em>. Capitalize only first letters of acronyms. For example <em>HttpUrl</em> instead of <em>HTTPURL</em>. Methods and field names follow the same convention, except that the first letter should be lowercase. for example <em>ensureCapacity</em>.</p>
 * <p>Constant fields should consist of one or more uppercase words separated by the underscore character. for example <em>NEGATIVE_INFINITY</em>.</p>
 * <p>type paremeter names usually consist of a single letter. Most commonly <em>T</em> for arbitrary type, <em>E</em> for element type of collection, <em>K</em> and <em>V</em> for key and value type and <em>X</em> for an exception.</p>
 * <strong>Grammatical Conventions : </strong>
 * <p>Non-instantiable utility classes are often named with plural noun such as <em>Collections</em>.</p>
 * <p>Methods that return a non-boolean function or attribute of the object on which they're invoked are usually named with noun, noun phrase, or a verb phrase. for example <em>size</em>, <em>hashCode</em> or <em>getTime</em>.</p>
 * <p>Instance method that convrth teh type of an object returning an independent object are often called <em>toType</em> such as  <em>toArray</em>, methods that return a view as  <em>asType</em> such as <em>asList</em>. Static factory methods <em>valueOf</em>, <em>getInstance</em>, <em>newInstance</em>.</p>
 */
public class Item68 {
    private Item68() {
    }
}
