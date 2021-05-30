import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogContentText,
    DialogTitle, MenuItem, Select,
    TextField
} from "@material-ui/core";
import {useState} from "react";

const useStyles = makeStyles({
    formControl: {
        width: '90%',
        margin: '5px 5px'
    },
});

function Filters(props) {
    const classes = useStyles();

    const [searchDistance, setSearchDistance] = useState(props.currentDistance)

    const handleDistanceChange = (e) => {
        setSearchDistance(e.target.value)
    }

    const temperatureMarks = [
        {
            value: 0,
            label: offset + '°C',
        },
        {
            value: stepSize * magnifier,
            label: offset + stepSize + '°C',
        },
        {
            value: 2 * stepSize * magnifier,
            label: offset + 2 * stepSize + '°C',
        },
        {
            value: 3 * stepSize * magnifier,
            label: offset + 3 * stepSize + '°C',
        },
        {
            value: 4 * stepSize * magnifier,
            label: offset + 4 * stepSize + '°C',
        },
        {
            value: 5 * stepSize * magnifier,
            label: offset + 5 * stepSize + '°C',
        },
    ];

    const calculateTemp = (temp) => {
        return temp / magnifier + offset
    }

    const submit = () => {
        props.search(props.loc, searchDistance)
        props.handleClose()
    }

    return (
        <div>
            <Dialog
                open={props.open}
                onClose={props.handleClose}
            >
                <DialogTitle>{"Filter your results"}</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        Select your filters to narrow down your search.
                    </DialogContentText>
                    <Select
                        labelId="search-distance"
                        value={searchDistance}
                        onChange={ (e) => setSearchDistance(e.target.value)}
                        variant="outlined"
                    >
                        <MenuItem value={10}>10</MenuItem>
                        <MenuItem value={20}>20</MenuItem>
                        <MenuItem value={30}>30</MenuItem>
                        <MenuItem value={40}>40</MenuItem>
                        <MenuItem value={50}>50</MenuItem>
                        <MenuItem value={1000}>All</MenuItem>
                    </Select>
                </DialogContent>
                <DialogActions>
                    <Button onClick={submit} color="primary">
                        Search
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    )
}

export default Filters;