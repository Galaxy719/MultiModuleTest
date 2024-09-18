package uz.developersdreamscore.presentation.designsystem.ui.components.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding10dp
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding12dp
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding14dp
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding16dp
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding20dp
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding2dp
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding4dp
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding6dp
import uz.developersdreamscore.presentation.designsystem.ui.theme.Padding8dp

@Composable
fun SpacerDynamic(
    padding: Dp = Padding10dp
) {
    Spacer(modifier = Modifier.padding(padding))
}

@Composable
fun Spacer2dp() {
    Spacer(modifier = Modifier.padding(Padding2dp))
}

@Composable
fun Spacer4dp() {
    Spacer(modifier = Modifier.padding(Padding4dp))
}

@Composable
fun Spacer6dp() {
    Spacer(modifier = Modifier.padding(Padding6dp))
}

@Composable
fun Spacer8dp() {
    Spacer(modifier = Modifier.padding(Padding8dp))
}

@Composable
fun Spacer10dp() {
    Spacer(modifier = Modifier.padding(Padding10dp))
}

@Composable
fun Spacer12dp() {
    Spacer(modifier = Modifier.padding(Padding12dp))
}

@Composable
fun Spacer14dp() {
    Spacer(modifier = Modifier.padding(Padding14dp))
}

@Composable
fun Spacer16dp() {
    Spacer(modifier = Modifier.padding(Padding16dp))
}

@Composable
fun Spacer20dp() {
    Spacer(modifier = Modifier.padding(Padding20dp))
}