<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <head>
                <link rel="stylesheet" href="ranking.css"/>
            </head>
            <body>
                <h1> Tabla de puntuacion </h1>
                <table>
                    <tr>
                        <th> Nombre </th>
                        <th> puntuacion</th>
                    </tr>
                    <xsl:for-each select="ranking/numero">
                        <tr>
                            <td>
                                <xsl:value-of select="nombre"/>
                            </td>
                            <td class="puntuacion">
                                <xsl:value-of select="puntuacion"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>