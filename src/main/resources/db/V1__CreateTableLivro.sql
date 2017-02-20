CREATE TABLE IF NOT EXISTS livro (
	id serial,
	nome text,
	autor text,
	descricao text,
	releaseDate DATE,
	photoUrl text,
	isbn text,
	year text,
	PRIMARY KEY( id )
);