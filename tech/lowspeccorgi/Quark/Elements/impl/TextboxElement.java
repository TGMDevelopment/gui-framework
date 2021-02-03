package tech.lowspeccorgi.Quark.Elements.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.input.Keyboard;
import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Style.RectStyle;
import tech.lowspeccorgi.Quark.primitives.Primitives;
import java.awt.*;

public class TextboxElement extends Element {
    private StringBuilder sb = new StringBuilder();
    private int cursorPosition = 0;
    private final Minecraft mc = Minecraft.getMinecraft();
    private int charLimit = 0;
    private RectStyle rectStyle;

    public TextboxElement(String id, int x, int y, int width, int height, RectStyle rectStyle) {
        super(id, x, y, width, height);
        this.rectStyle = rectStyle;
    }

    public TextboxElement(String id, int x, int y, int width, int height, int charLimit, RectStyle rectStyle) {
        super(id, x, y, width, height);
        this.charLimit = charLimit;
        this.rectStyle = rectStyle;
    }

    @Override
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        int cursorPos = this.x + 5 + (mc.fontRendererObj.getStringWidth(sb.substring(0, this.cursorPosition)));
        this.rectStyle.render(this.x, this.y, this.width, this.height);
        Primitives.startScissorBox(this.y, this.height, this.x, this.width);
        mc.fontRendererObj.drawString(sb.toString(), this.x, this.y, new Color(255, 255, 255, 255).getRGB());
        Primitives.endScissorBox();
        Primitives.drawRect(cursorPos, this.y ,cursorPos + 1, this.y + 10, -3092272);
    }

    @Override
    public void onKeyTyped(char typedChar, int keyCode)
    {
        switch (keyCode)
        {
            case Keyboard.KEY_BACK:
                if (cursorPosition > 0)
                {
                    sb.deleteCharAt(cursorPosition-1);
                    cursorPosition -= 1;
                }
                break;
            case Keyboard.KEY_LEFT:
                if (cursorPosition > 0)
                {
                    cursorPosition -= 1;
                }
                break;
            case Keyboard.KEY_RIGHT:
                if (cursorPosition < sb.length())
                {
                    cursorPosition += 1;
                }
                break;
            default:
                if (this.charLimit == 0 || sb.length() < this.charLimit)
                {
                    if (ChatAllowedCharacters.isAllowedCharacter(typedChar))
                    {
                        sb.insert(cursorPosition, typedChar);

                        if (sb.length() > 0) {
                            cursorPosition += 1;
                        }
                    }
                }
                break;
        }
    }

    public String getText()
    {
        return this.sb.toString();
    }
}
