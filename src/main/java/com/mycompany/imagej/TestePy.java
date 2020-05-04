/*
 * To the extent possible under law, the ImageJ developers have waived
 * all copyright and related or neighboring rights to this tutorial code.
 *
 * See the CC0 1.0 Universal license for details:
 *     http://creativecommons.org/publicdomain/zero/1.0/
 */

package com.mycompany.imagej;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.WindowManager;
import ij.gui.GenericDialog;
import ij.plugin.PlugIn;
import ij.process.ImageProcessor;

public class TestePy implements PlugIn	 {
	protected ImagePlus image;
	protected double valor;
	protected String env;
	protected String property = "java.io.tmpdir"; 
	protected String tempDir = System.getProperty(property);
	protected String nomeArquivo;
	protected String dirArquivo;

	

	@Override
	public void run(String ip) {
		try {
			
			nomeArquivo  = WindowManager.getCurrentImage().getOriginalFileInfo().fileName;
			dirArquivo   = WindowManager.getCurrentImage().getOriginalFileInfo().directory;
			WindowManager.getCurrentImage().close();


						
			String testeStrings = "import sys\n" + "import pyvips\n" + "import logging     \n"
					+ "LOG_FILENAME = 'log.txt'\n" + "logging.basicConfig(filename=LOG_FILENAME, level=logging.DEBUG)\n"
					+ "#logging.basicConfig(level = logging.DEBUG)\n" + "#            \n" + "#   \n" + "#    \n"
					+ "#           \n" + "# threshold ... why not\n" + "try:\n" + "	T = float(sys.argv[3])\n" + "\n"
					+ "	ps = pyvips.Image.new_from_file(sys.argv[1], access='sequential')\n" + "	 \n"
					+ "	# window size (neighbourhood) we search over\n" + "	window_size = 3\n" + "		    \n"
					+ "	# find the max and min for each window\n" + "	ps_min = ps.rank(window_size, window_size, 0)\n"
					+ "	ps_max = ps.rank(window_size, window_size, window_size * window_size - 1)\n" + "	  \n"
					+ "	# difference   \n" + "	D = ps_max - ps_min\n" + "\n" + "	# for border pixels,\n"
					+ "	border = (ps - ps_min < ps_max - ps).ifthenelse(ps_min, ps_max)\n" + "	  \n"
					+ "	out_ps = (D < T).ifthenelse(ps, border)\n" + "		\n" + "		  \n" + "\n"
					+ "	out_ps.write_to_file(sys.argv[2])\n" + "\n" + "except:\n"
					+ "    logging.exception('Pegamos um erro aqui')\n" + "    raise";

			File file = new File(tempDir+File.separator+"config-delin.txt");

			if (file.exists()) {
				FileReader arq = new FileReader(file);
				BufferedReader lerArq = new BufferedReader(arq);
				env = lerArq.readLine();
				lerArq.close();
			}

			BufferedWriter out2 = new BufferedWriter(new FileWriter(tempDir+File.separator+"testStrings.py"));
			out2.write(testeStrings);
			out2.close();
			if (showDialog()) {
				Process p1 = Runtime.getRuntime()
						.exec(env + "python "+tempDir+File.separator+"testStrings.py "+dirArquivo+nomeArquivo+" "+tempDir+File.separator+nomeArquivo+" " + valor);
				p1.waitFor();
				
				ImagePlus imagemNova = IJ.openImage(tempDir+File.separator+nomeArquivo);
				imagemNova.show();

				IJ.showMessage("executado sem erro");
				BufferedWriter out = new BufferedWriter(new FileWriter(tempDir+File.separator+"config-delin.txt"));
				out.write(env);
				out.close();
			}

		} catch (IOException | InterruptedException e) {
			IJ.showMessage(e.getMessage());
		}

	}

	private boolean showDialog() {
		GenericDialog gd = new GenericDialog("Threshold value");

		gd.addNumericField("Threshold", 0.00, 2);
		gd.addStringField("Selecionar Env", env);

		gd.showDialog();
		if (gd.wasCanceled())
			return false;

		// get entered values
		valor = gd.getNextNumber();
		env = gd.getNextString();

		return true;
	}

	public void showAbout() {
		IJ.showMessage("Teste Python", "Teste execução chamada de script py");
	}

	public static void main(String[] args) throws Exception {
		Class<?> clazz = TestePy.class;
		java.net.URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
		java.io.File file = new java.io.File(url.toURI());
		System.setProperty("plugins.dir", file.getAbsolutePath());

		// start ImageJ
		new ImageJ();

		// open the Clown sample
		ImagePlus image = IJ.openImage("http://imagej.net/images/clown.jpg");
		image.show();

		// run the plugin
		IJ.runPlugIn(clazz.getName(), "");
	}
}
