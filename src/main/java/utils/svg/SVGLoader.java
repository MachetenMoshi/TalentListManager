package utils.svg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jfoenix.svg.SVGGlyph;

import javafx.scene.paint.Color;
import utils.StringUtils;

public class SVGLoader {

	private static final String SVG_FOLDER = "/svg/";
	private static final String FILE_TYPE = ".svg";
	private static Map<SVG, GlyphBuilder> glyphMap = new HashMap<>();

	private SVGLoader() {

	}

	public static SVGGlyph loadSVGGlyph(SVG svg) {
		return loadSVGGlyph(svg, (String[]) null);
	}

	public static SVGGlyph loadSVGGlyph(SVG svg, String... styleClasses) {
		if (svg != null && !StringUtils.isNullOrEmpty(svg.getName())) {
			String name = svg.getName();
			if (!name.endsWith(FILE_TYPE))
				name = name.concat(FILE_TYPE);
			try {
				if (!glyphMap.containsKey(svg)) {
					GlyphBuilder builder = new GlyphBuilder(svg, extractSvgPath(getStringFromInputStream(
							SVGLoader.class.getResource(SVG_FOLDER.concat(name)).openStream())));
					glyphMap.put(svg, builder);
					SVGGlyph glyph = builder.build();
					addStyleClasses(glyph, styleClasses);
					return glyph;
				} else {
					SVGGlyph glyph = glyphMap.get(svg).build();
					addStyleClasses(glyph, styleClasses);
					return glyph;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private static void addStyleClasses(SVGGlyph glyph, String... styleClasses) {
		if (styleClasses != null && styleClasses.length > 0) {
			List<String> styleClassList = new ArrayList<>(Arrays.asList(styleClasses));
			styleClassList = styleClassList.stream().filter(p -> p != null && !p.isEmpty())
					.collect(Collectors.toList());
			if (!styleClassList.isEmpty())
				glyph.getStyleClass().addAll(styleClassList);
		}
	}

	public static void remove(SVG svg) {
		if (glyphMap.containsKey(svg))
			glyphMap.remove(svg);
	}

	public static void clear() {
		glyphMap.clear();
	}

	private static String extractSvgPath(String svgString) {
		return svgString.replaceFirst(".*d=\"", "").replaceFirst("\".*", "");
	}

	private static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	private static final class GlyphBuilder {

		private SVG svg;
		private String svgPathContent;

		GlyphBuilder(SVG svg, String svgPathContent) {
			this.svg = svg;
			this.svgPathContent = svgPathContent;
		}

		SVGGlyph build() {
			return new SVGGlyph(-1, svg.getName(), svgPathContent, Color.BLACK);
		}
	}

}
