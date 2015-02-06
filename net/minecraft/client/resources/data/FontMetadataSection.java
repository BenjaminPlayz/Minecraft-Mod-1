package net.minecraft.client.resources.data;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FontMetadataSection implements MetadataSection
{
    private final float[] charWidths;
    private final float[] charLefts;
    private final float[] charSpacings;

    public FontMetadataSection(float[] par1ArrayOfFloat, float[] par2ArrayOfFloat, float[] par3ArrayOfFloat)
    {
        this.charWidths = par1ArrayOfFloat;
        this.charLefts = par2ArrayOfFloat;
        this.charSpacings = par3ArrayOfFloat;
    }
}
