import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogContentText,
    DialogTitle, MenuItem, Select,
    TextField
} from "@material-ui/core";
import ResortList from "./ResortList";
import {useState} from "react";


function Filters(props) {

    const [searchDistance, setSearchDistance] = useState(props.currentDistance)

    const handleDistanceChange = (e) => {
        setSearchDistance(e.target.value)
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