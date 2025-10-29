namespace labs1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }


        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            textBox1.Text = "Начинаем работу";
            vScrollBar1.Width = 70;
            button2.BackColor = Color.Yellow;
            button1.BackColor = Color.LightBlue;
            radioButton2.Hide();
        }

        private void vScrollBar1_Scroll(object sender, ScrollEventArgs e)
        {

        }
        private void button2_Click(object sender, EventArgs e)
        {
            hScrollBar1.Width = 180;

            textBox1.Text = "Ширина полосы = 180";

            radioButton2.Show();

            button2.BackColor = Color.Red;

            this.BackColor = Color.LightBlue;

        }

        private void hScrollBar1_Scroll(object sender, ScrollEventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {

        }
    }
}
