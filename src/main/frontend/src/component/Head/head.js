import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';
import AppBar from "@mui/material/AppBar";
import {Button, Container} from "@mui/material";

export default function NavBar(props) {
    const [open, setOpen] = props.sideOpen;

    const drawerWidth = 240;
    return (
        <Box sx={{flexGrow: 1}}>
            <AppBar sx={{zIndex:2}} position="relative" color='primary' enableColorOnDark={true}>
                <Toolbar>
                    <IconButton
                        size="large"
                        edge="start"
                        color="inherit"
                        aria-label="menu"
                        sx={{mr: 2}}
                        onClick={() => {
                            open ? setOpen(false) : setOpen(true)
                        }}
                    >
                        <MenuIcon></MenuIcon>
                    </IconButton>
                    <Typography variant="h6" component="div" sx={{flexGrow: 1}}>
                        MyBoard
                    </Typography>
                    <Button color="inherit">Login</Button>
                </Toolbar>
            </AppBar>
        </Box>
    );
}