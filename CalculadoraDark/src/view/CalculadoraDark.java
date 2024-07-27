package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class CalculadoraDark extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDisplay;
	private Color corBotao;
	private Color corFundo;
	private Color corTexto;
	private Color corLinha;
	private static int x;
	private static int y;
	private boolean blackMode = true;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraDark frame = new CalculadoraDark();
					frame.setLocationRelativeTo(frame);
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setOpacity((float) 0.99);
					frame.setTitle("Calculadora");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalculadoraDark() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadoraDark.class.getResource("/image/icone.png")));

		corBotao = new Color(70, 71, 74);
		corTexto = Color.white;
		corFundo = new Color(53, 53, 53);
		corLinha = new Color(53, 53, 53);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 490);
		contentPane = new JPanel();
		contentPane.setBackground(corFundo);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		movimentarTela();
		
		JLabel btnModo = new JLabel();
		btnModo.setIcon(new ImageIcon(CalculadoraDark.class.getResource("/image/whiteMode.png")));
		btnModo.setBounds(0, 0, 40, 30);
		contentPane.add(btnModo);

		JButton btnFechar = criarBotao("x", 280, 0, 40, 30);
		btnFechar.addActionListener(this);
		contentPane.add(btnFechar);
	

		textFieldDisplay = new JTextField();
		textFieldDisplay.setBorder(null);
		textFieldDisplay.setEditable(false);
		textFieldDisplay.setFont(new Font("Tahoma", Font.PLAIN, 48));
		textFieldDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldDisplay.setText("0");
		textFieldDisplay.setForeground(Color.WHITE);
		textFieldDisplay.setBounds(0, 32, 320, 60);
		textFieldDisplay.setBackground(new Color(53, 53, 53));
		contentPane.add(textFieldDisplay);
		textFieldDisplay.setColumns(10);

		JButton btnApagar = criarBotao("C", 0, 90, 160, 80);
		btnApagar.addActionListener(this);
		contentPane.add(btnApagar);

		JButton btnMultiplicacao = criarBotao("*", 160, 90, 80, 80);
		btnMultiplicacao.addActionListener(this);
		contentPane.add(btnMultiplicacao);

		JButton btnDivisao = criarBotao("/", 240, 90, 80, 80);
		btnDivisao.addActionListener(this);
		contentPane.add(btnDivisao);

		JButton btnSubtracao = criarBotao("-", 240, 170, 80, 80);
		btnSubtracao.addActionListener(this);
		contentPane.add(btnSubtracao);

		JButton btnSoma = criarBotao("+", 240, 250, 80, 80);
		btnSoma.addActionListener(this);
		contentPane.add(btnSoma);

		JButton btnIgual = criarBotao("=", 240, 330, 80, 160);
		btnIgual.addActionListener(this);
		contentPane.add(btnIgual);

		JButton btnZero = criarBotao("0", 0, 410, 160, 80);
		btnZero.addActionListener(this);
		contentPane.add(btnZero);

		JButton btnPonto = criarBotao(".", 160, 410, 80, 80);
		btnPonto.addActionListener(this);
		contentPane.add(btnPonto);

		JPanel panelBotoesNumericos = new JPanel();
		panelBotoesNumericos.setBounds(0, 170, 240, 320);
		panelBotoesNumericos.setLayout(new GridLayout(4, 3));
		panelBotoesNumericos.setBorder(null);
		panelBotoesNumericos.setBackground(corFundo);
		panelBotoesNumericos.setOpaque(true);

		String[] botoesNumericos = { "7", "8", "9", "4", "5", "6", "1", "2", "3" };

		for (String button : botoesNumericos) {
			JButton btn = new JButton(button);
			btn.addActionListener(this);
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			btn.setFont(new Font("Tahoma", Font.PLAIN, 36));
			btn.setForeground(Color.WHITE);
			btn.setFocusPainted(false);
			btn.setBackground(corBotao);
			btn.setBorder(new LineBorder(corLinha, 2));
			panelBotoesNumericos.add(btn);
		}
		contentPane.add(panelBotoesNumericos);

		// alterar cor do botao ao passar o mouse
		for (Component component : contentPane.getComponents()) {
			if (component instanceof JButton) { //outros botoes
				JButton btn = (JButton) component;
				alternarCorBotao(btn);
			}
			if (component instanceof JPanel) {// percorrer panelBotoes 1 a 9
				for (Component botoesPanel : ((JPanel) component).getComponents()) {
					if (botoesPanel instanceof JButton) {
						JButton btn = (JButton) botoesPanel;
						alternarCorBotao(btn);
					}
				}
			}
		}

		btnModo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				blackMode = !blackMode;
				if (blackMode) {
					btnModo.setIcon(new ImageIcon(CalculadoraDark.class.getResource("/image/whiteMode.png")));

					corBotao = new Color(70, 71, 74);
					corTexto = Color.white;
					corFundo = new Color(53, 53, 53);
					corLinha = new Color(53, 53, 53);

					contentPane.setBackground(Color.white);
					panelBotoesNumericos.setBackground(Color.white);
					textFieldDisplay.setBackground(corFundo);
					textFieldDisplay.setForeground(Color.white);
					for (Component component : contentPane.getComponents()) {
						if (component instanceof JButton) {
							JButton btn = (JButton) component;

							btn.setForeground(corTexto);
							btn.setBackground(corBotao);
							btn.setBorder(new LineBorder(corLinha, 2));
							contentPane.setBackground(corFundo);
						}
						if (component instanceof JPanel) {// panelBotoes
							for (Component botoesPanel : ((JPanel) component).getComponents()) {
								if (botoesPanel instanceof JButton) {
									JButton btn = (JButton) botoesPanel;
									btn.setForeground(corTexto);
									btn.setBackground(corBotao);
									btn.setBorder(new LineBorder(corLinha, 2));
									contentPane.setBackground(corFundo);
								}
							}
						}
					}
				} else {

					btnModo.setIcon(new ImageIcon(CalculadoraDark.class.getResource("/image/blackMode.png")));
					corFundo = Color.white;
					corBotao = new Color(204, 204, 204);
					corTexto = new Color(77, 77, 77);
					corLinha = Color.white;
					contentPane.setBackground(Color.white);
					panelBotoesNumericos.setBackground(Color.white);
					textFieldDisplay.setBackground(Color.white);
					textFieldDisplay.setForeground(corTexto);
					for (Component component : contentPane.getComponents()) {
						if (component instanceof JButton) {
							JButton btn = (JButton) component;

							btn.setForeground(corTexto);
							btn.setBackground(corBotao);
							btn.setBorder(new LineBorder(corLinha, 2));
							contentPane.setBackground(corFundo);
						}
						if (component instanceof JPanel) {// panelBotoes
							for (Component botoesPanel : ((JPanel) component).getComponents()) {
								if (botoesPanel instanceof JButton) {
									JButton btn = (JButton) botoesPanel;
									btn.setForeground(corTexto);
									btn.setBackground(corBotao);
									btn.setBorder(new LineBorder(corLinha, 2));
									contentPane.setBackground(corFundo);
								}
							}
						}
					}

				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

//		System.out.println(comando);
		if ("=".equals(comando)) {
			String expressao = textFieldDisplay.getText();
			double resultado = verificarExpressao(expressao);
			textFieldDisplay.setText(Double.toString(resultado));
		} else if ("C".equals(comando)) {
			// limpar display
			textFieldDisplay.setText("0");
		} else if ("x".equalsIgnoreCase(comando)) {
			dispose();
		} else {
			// concatena o que tem no display com o último comando

			String textoDisplay = textFieldDisplay.getText();
			char lastChar = textoDisplay.charAt(textoDisplay.length() - 1);
			if (isOperador(lastChar) && isOperador(comando.charAt(comando.length() - 1))) {
				// Substitui o último operador pelo novo operador
				textoDisplay = textoDisplay.substring(0, textoDisplay.length() - 1);
				textFieldDisplay.setText(textoDisplay + comando);
			} else {
				if (textFieldDisplay.getText().equalsIgnoreCase("0")) {
					textFieldDisplay.setText("");
				}
				textFieldDisplay.setText(textFieldDisplay.getText() + comando);
			}
		}

	}

	private boolean isOperador(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private double verificarExpressao(String expressao) {
		try {
			// Remove espaços em branco e caracteres inválidos da expressão
			expressao = expressao.replaceAll("\\s+", "");

			// Verifica se a expressão é vazia
			if (expressao.isEmpty()) {
				return 0;
			}

			// Divide a expressão em partes separadas pelos operadores
			Pattern pattern = Pattern.compile("[+\\-*/]");
			Matcher matcher = pattern.matcher(expressao);
			String[] partesDaExpressao = pattern.split(expressao);

			// Converte as partes em números e operadores
			double result = Double.parseDouble(partesDaExpressao[0]);
			int i = 1;

			// Realiza as operações sequencialmente
			while (matcher.find()) {
				String operator = matcher.group();
				double value = Double.parseDouble(partesDaExpressao[i++]);
				switch (operator) {
				case "+":
					result += value;
					break;
				case "-":
					result -= value;
					break;
				case "*":
					result *= value;
					break;
				case "/":
					result /= value;
					break;
				}
			}

			return result;
		} catch (NumberFormatException | ArithmeticException e) {
			// Em caso de erro, retorna 0.0
			return 0;
		}
	}

	private JButton criarBotao(String botao, int x, int y, int width, int height) {
		JButton jButton = new JButton(botao);
		jButton.setHorizontalAlignment(SwingConstants.CENTER);
		jButton.setFont(new Font("Tahoma", Font.PLAIN, botao.equalsIgnoreCase("x") ? 20 : 36));
		jButton.setForeground(corTexto);
		jButton.setFocusPainted(false);
		jButton.setBackground(corBotao);
		jButton.setBorder(new LineBorder(corLinha, 2));
		jButton.setBounds(x, y, width, height);

		return jButton;
	}

	private void alternarCorBotao(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(corFundo);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(corBotao);
			}
		});
	}

	private void movimentarTela() {
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
	}
}