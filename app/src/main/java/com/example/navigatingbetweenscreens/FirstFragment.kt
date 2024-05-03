package com.example.navigatingbetweenscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

// Константы для параметров фрагмента
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FirstFragment : Fragment() {
    // Поля для параметров фрагмента
    private var param1: String? = null
    private var param2: String? = null

    // Метод, вызываемый при создании фрагмента
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Извлекаем параметры фрагмента из аргументов
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    // Метод, вызываемый при создании представления фрагмента
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Заполняем представление фрагмента из макета fragment_first.xml
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Находим TextView с id textView1 в представлении фрагмента
        val textView1 = view.findViewById<TextView>(R.id.textView1)
        // Устанавливаем обработчик клика на TextView
        textView1.setOnClickListener {
            // Создаем действие для перехода на SecondFragment
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Пролило солнце\n" +
                    "В реку золото заката.\n" +
                    "Знать богат был день.")
            // Переходим на SecondFragment, используя действие из графа навигации
            findNavController().navigate(action)
        }
        // Возвращаем созданное представление фрагмента
        return view
    }

    // Фабричный метод для создания экземпляра FirstFragment
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
