<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Ranking · El despertar del héroe</title>
                <link rel="stylesheet" href="ranking.css"/>
            </head>
            <body>
                <h1> Tabla de puntuacion </h1>
                <xsl:choose>

                    <xsl:when test="count(ranking/numero) = 0">
                        <p class="vacio">Todavía no hay puntuaciones en el ranking.</p>
                    </xsl:when>
                <xsl:otherwise>
                <table>
                        <tr>
                                <th> Posición </th>
                                <th> Nombre </th>
                                <th> Puntuación </th>
                            </tr>
                            <xsl:for-each select="ranking/numero">
                                <xsl:sort select="puntuacion" data-type="number" order="descending"/>
                                <tr>
                                    <td><xsl:value-of select="position()"/></td>
                                    <td><xsl:value-of select="nombre"/></td>
                                    <td class="puntuacion"><xsl:value-of select="puntuacion"/></td>
                                </tr>
                            </xsl:for-each>
                        </table>
                    </xsl:otherwise>
                </xsl:choose>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
