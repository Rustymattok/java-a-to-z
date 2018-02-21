<!--?xml version="1.0"?-->  
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">  
<xsl:template match="entries">  
<entries>
<xsl:text>&#10;</xsl:text>
<xsl:for-each select="entry">
<entry field="{field}"/>
<xsl:text>&#10;</xsl:text>
</xsl:for-each>
</entries>
</xsl:template>  
</xsl:stylesheet>  