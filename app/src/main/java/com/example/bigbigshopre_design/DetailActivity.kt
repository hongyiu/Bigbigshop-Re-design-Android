package com.example.bigbigshopre_design

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bigbigshopre_design.databinding.ActivityDetailBinding
import com.example.bigbigshopre_design.lists.book.BOOK_ID_EXTRA
import com.example.bigbigshopre_design.lists.book.Book
import com.example.bigbigshopre_design.lists.book.bookList

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookID = intent.getIntExtra(BOOK_ID_EXTRA, -1)
        Log.i(TAG, bookID.toString())
        val book = bookFromID(bookID)
        if (book != null) {
            binding.cover.setImageResource(book.cover)
            binding.title.text = book.title
            binding.author.text = book.author
            binding.description.text = book.description
        }
    }

    private fun bookFromID(bookID: Int): Book? {
        for (book in bookList) {
            if (book.id == bookID) return book
        }
        return null
    }
}