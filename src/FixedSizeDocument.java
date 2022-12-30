import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
// Fonction nous permettant de limiter les cases à une seule case
public class FixedSizeDocument extends PlainDocument
{
    private int max;

    public FixedSizeDocument(int max)
    {
        this.max = max;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException
    {

        if (getLength()+str.length()>max)
        {

            str = str.substring(0, max - getLength());
        }
        super.insertString(offs, str, a);
    }
}