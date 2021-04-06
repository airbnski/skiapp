import {Toolbar, Typography} from "@material-ui/core";

export default function AppBar() {
    return (
        <Toolbar style={{background: '#204A70', color: 'white', height: 60}}>
            <Typography variant="h6">
                AirBNSki
            </Typography>
        </Toolbar>
    );

}