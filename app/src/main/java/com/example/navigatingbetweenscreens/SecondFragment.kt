package com.example.navigatingbetweenscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

// Константы для параметров фрагмента
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SecondFragment : Fragment() {
    // Поля для параметров фрагмента
    private var param1: String? = null
    private var param2: String? = null
    // Аргумент, переданный из FirstFragment
    val args: SecondFragmentArgs by navArgs()

    // Метод, вызываемый при создании фрагмента
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Извлекаем параметры фрагмента из аргументов
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Заполняем представление фрагмента из макета fragment_second.xml
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        // Находим TextView с id textView2 в представлении фрагмента
        val textView1 = view.findViewById<TextView>(R.id.textView2)
        // Получаем аргумент "string", который был передан из FirstFragment
        val myNumber = args.string
        // Устанавливаем текст TextView2 со значением аргумента
        textView1.setText(myNumber.toString())
        // Устанавливаем обработчик клика на TextView2
        textView1.setOnClickListener {
            // Переходим обратно на FirstFragment, используя действие из графа навигации
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
        // Возвращаем созданное представление фрагмента
        return view
    }

    // Фабричный метод для создания экземпляра SecondFragment
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
