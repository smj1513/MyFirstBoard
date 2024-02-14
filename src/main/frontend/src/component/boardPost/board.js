import {
    Button,
    Container,
    Pagination,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@mui/material";
import {useEffect, useState} from "react";
import axios from "axios";
import {format} from "date-fns";
import Box from "@mui/material/Box";

export default function Board(props) {

    const [pageCount, setPageCount] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(10);
    const [posts, setPosts] = useState([]);
    const [pageState, setPageState] = useState({pNum: 1, paging: {}, boards: []})

    const requestPage = (pageNumber) => {
        axios.get(`/boardPost/list?page=${pageNumber}`).then((request) => {
            const postData = request.data;
            setPageCount(postData.pageCount);
            setPosts(postData.posts);
        })
    }


    useEffect(() => {
        requestPage(1);
    }, []);
    return (
        <Container maxWidth={'lg'} style={{marginTop: '2vh'}}>
            <Box style={{justifyContent: 'right', display: 'flex'}}>
                <Button size='large' variant='contained'>글쓰기</Button>
            </Box>
            <TableContainer component={Paper} style={{marginTop: '1vh'}}>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell align={'center'} color={'red'}>번호</TableCell>
                            <TableCell align={'center'}>제목</TableCell>
                            <TableCell align={'center'}>추천수</TableCell>
                            <TableCell align={'center'}>작성자</TableCell>
                            <TableCell align={'center'}>작성일</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {

                            posts.map((post) => {
                                return (
                                    <TableRow key={post.id}>
                                        <TableCell align={'center'}>{post.number}</TableCell>
                                        <TableCell sx={'width:500px'} align={'left'}>{post.title}</TableCell>
                                        <TableCell align={'center'}>{post.upVotesCount}</TableCell>
                                        <TableCell align={"center"}>{post.writer}</TableCell>
                                        <TableCell align={'center'}>{format(post.createdAt, 'MMMM do yyyy')}</TableCell>
                                    </TableRow>
                                );
                            })
                        }
                    </TableBody>
                </Table>
            </TableContainer>
            <Box style={{marginTop: '2vh', display: 'flex', justifyContent: 'center'}}>
                <Pagination count={pageCount} color="primary" size='large' variant='outlined'
                            onChange={(event, page)=>{
                                requestPage(page);
                            }}
                            showFirstButton
                            showLastButton
                />
            </Box>
        </Container>
    )
}