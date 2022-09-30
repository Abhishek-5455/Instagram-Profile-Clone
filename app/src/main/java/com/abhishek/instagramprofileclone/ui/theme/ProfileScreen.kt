package com.abhishek.instagramprofileclone.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.instagramprofileclone.ImageWithText
import com.abhishek.instagramprofileclone.R
private val highlightsItems = listOf(
    ImageWithText(
        imageIdRes = R.drawable.img_1,
        description = "Highlight 1"
    ),
    ImageWithText(
        imageIdRes = R.drawable.img_2,
        description = "Highlight 2"
    ),
    ImageWithText(
        imageIdRes = R.drawable.img_3,
        description = "Highlight 3"
    ),
    ImageWithText(
        imageIdRes = R.drawable.img_4,
        description = "Highlight 4"
    ),
    ImageWithText(
        imageIdRes = R.drawable.img_5,
        description = "Highlight 5"
    ),
    ImageWithText(
        imageIdRes = R.drawable.img_6,
        description = "Highlight 6"
    ),
    ImageWithText(
        imageIdRes = R.drawable.img_7,
        description = "Highlight 7"
    ),
    ImageWithText(
        imageIdRes = R.drawable.img_8,
        description = "Highlight 8"
    ),
)

private val gridItem = listOf(
    ImageWithText(
        imageIdRes = R.drawable.ic_grid,
        description = "Posts"
    ),
    ImageWithText(
        imageIdRes = R.drawable.ic_reels,
        description = "reels"
    ),
    ImageWithText(
        imageIdRes = R.drawable.ic_igtv,
        description = "igtv"
    ),
    ImageWithText(
        imageIdRes = R.drawable.profile,
        description = "profile"
    )
)
@Composable
fun ProfileScreen(){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            name = "Abhishek_Rathod_5455",
            modifier = Modifier.padding(top = 12.dp, start = 8.dp , end = 8.dp , bottom = 8.dp)
        )
        ProfileSection()
        ProfileDescription(
            name = "_wolfPack_26_",
            description = "Programmer </>\n" +
                    "Talk less , Do more !!",
            url = "androidDev/Abhishek",
            followedBy = listOf("nobody_001" , "nobody_002"),
            otherCount = 12
        )
        ButtonSection(modifier = Modifier.fillMaxWidth())
        HighlightsSection(imageList = highlightsItems)
        PostTabView(onTabSelected = { selectedTabIndex = it }, tabItems = gridItem)

        when(selectedTabIndex){
            0 -> PostSection(images = listOf(
                    painterResource(id = R.drawable.img_1),
                    painterResource(id = R.drawable.img_2),
                    painterResource(id = R.drawable.img_3),
                    painterResource(id = R.drawable.img_4),
                    painterResource(id = R.drawable.img_5),
                    painterResource(id = R.drawable.img_6),
                    painterResource(id = R.drawable.img_7),
                    painterResource(id = R.drawable.img_8),
                    painterResource(id = R.drawable.profile_image)
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
@Composable
fun TopBar(
    name : String,
    modifier : Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Arrow",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "bell",
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "menu",
            modifier = Modifier.size(20.dp)
        )
    }
}

@Preview
@Composable
fun DefaultProfileSection(){
    InstagramProfileCloneTheme {
        ProfileScreen()
    }
}


@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            RoundImage(
                R.drawable.profile_image,
                description = "profile_image",
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            StateSection(
                modifier = Modifier.weight(7f)
            )
        }
    }
}
@Composable
fun RoundImage(
    @DrawableRes imageId : Int,
    description : String,
    modifier : Modifier = Modifier
){
    Image(
        painter = painterResource(id = imageId),
        contentDescription = description,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(1.dp, color = Color.Gray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}
@Composable
fun StateSection(
    modifier : Modifier = Modifier
){
    Row(
       modifier = modifier,
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.Center
    ){
        ProfileStates(numberText = "13", text = "Posts")
        Spacer(modifier = Modifier.width(15.dp))
        ProfileStates(numberText = "677", text = "Followers")
        Spacer(modifier = Modifier.width(15.dp))
        ProfileStates(numberText = "111", text = "Following")
    }
}
@Composable
fun ProfileStates(
    numberText : String ,
    text : String ,
    modifier : Modifier = Modifier
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = numberText,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
    }
}
@Composable
fun ProfileDescription(
    name : String,
    description : String,
    url : String,
    followedBy : List<String>,
    otherCount : Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 20.dp)) {
        Text(
            text = name ,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = description,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = url ,
            color = Color(0xFF3D3D91),
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        if(followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed{idx , name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if(idx < followedBy.size - 1){
                            append(", ")
                        }
                    }
                    if(otherCount > 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing ,
                lineHeight = lineHeight
            )
        }
    }
}
@Composable
fun HighlightsSection(
    imageList : List<ImageWithText>
){
    LazyRow(
        modifier = Modifier.padding(20.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        items(imageList){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 12.dp)
            ) {
                RoundImage(
                    imageId = it.imageIdRes,
                    description = it.description,
                    modifier = Modifier.size(80.dp)
                )
            }
        }
    }
}

@Composable
fun ButtonSection(
    modifier : Modifier = Modifier
){
    Row(
        modifier = modifier.padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        ActionButton(text = "Following", modifier = Modifier
            .defaultMinSize(90.dp)
            .height(30.dp)
        )
        ActionButton(text = "Message", modifier = Modifier
            .defaultMinSize(90.dp)
            .height(30.dp)
        )
        ActionButton(text = "Contact", modifier = Modifier
            .defaultMinSize(90.dp)
            .height(30.dp)
        )
        ActionButton(icon = Icons.Default.ArrowDropDown, modifier = Modifier
            .height(30.dp)
            .defaultMinSize(30.dp)
        )
    }

}
@Composable
fun ActionButton(
    modifier : Modifier = Modifier,
    text : String? = null,
    icon : ImageVector? = null
){
    Row(
        modifier = modifier
            .border(
                2.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        if(text != null){
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if(icon != null){
            Icon(
                imageVector = icon,
                contentDescription = "Arrow Down",
                tint = Color.Black
            )
        }
    }
}

@Composable
fun PostTabView(
    modifier : Modifier = Modifier,
    onTabSelected : (selectedIndex : Int) -> Unit,
    tabItems : List<ImageWithText>
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inActiveColor = Color(0xFF777777)
    
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        tabItems.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex==index,
                onClick = { selectedTabIndex = index
                    onTabSelected(index)},
                unselectedContentColor = inActiveColor,
                selectedContentColor = Color.Black
            ) {
                Icon(
                    painter = painterResource(id = item.imageIdRes),
                    contentDescription = item.description,
                    tint = if(selectedTabIndex == index) Color.Black else inActiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    images : List<Painter>,
    modifier : Modifier = Modifier
){
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = modifier.scale(1.01f)){
        items(images.size){
            Image(
                painter = images[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}