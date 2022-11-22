package com.example.thirtydays.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thirtydays.R

// Set of Material typography styles to start with
val JoseFinsans = FontFamily(
    Font(R.font.josefinsans_bold, FontWeight.Bold),
    Font(R.font.josefinsans_regular, FontWeight.Normal),
    Font(R.font.josefinsans_thinitalic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.josefinsans_lightitalic, FontWeight.Light, FontStyle.Italic)
)

val Typography = Typography(
    defaultFontFamily = JoseFinsans,

    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Italic,
        fontSize = 25.sp
    ),

    body1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 19.sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)