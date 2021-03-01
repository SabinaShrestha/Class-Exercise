using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Speech.Synthesis;

namespace SpeakQuote1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.BackgroundColor = ConsoleColor.DarkBlue;

            Console.WriteLine("My favriote Quote is: ");

            SpeechSynthesizer synth = new SpeechSynthesizer();
            synth.SetOutputToDefaultAudioDevice();

            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("Develop success from failures. Discouragement and failure are two of the surest stepping stones to success. -Dale Carnegie");
            synth.Speak("Develop success from failures. Discouragement and failure are two of the surest stepping stones to success. -Dale Carnegie");
        }
    }
}
